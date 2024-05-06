import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        int n = accounts.size();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (!(map.containsKey(accounts.get(i).get(j)))) {
                    map.put(accounts.get(i).get(j), i);
                } else {
                    unionBySize(i, map.get(accounts.get(i).get(j)));
                }
            }
        }
        ArrayList<String>[] mergelist = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergelist[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = findPar(it.getValue());
            mergelist[node].add(mail);
        }
        for (int i = 0; i < n; i++) {
            if (mergelist[i].size() == 0) {
                continue;
            }
            Collections.sort(mergelist[i]);
            List<String> curr = new ArrayList<>();
            curr.add(accounts.get(i).get(0));
            for (String j : mergelist[i]) {
                curr.add(j);
            }
            ans.add(curr);
        }
        return ans;

    }

    public int findPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));

        }
    }

}