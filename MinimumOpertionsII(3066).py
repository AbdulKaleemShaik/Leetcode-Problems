import heapq
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        minheap=[]
        for i in nums:
            minheap.append(i)
        
        heapq.heapify(minheap)
        ans=0
        while(minheap[0] <k):
            num1=heapq.heappop(minheap)
            num2=heapq.heappop(minheap)
            z=min(num1,num2)*2 + max(num1,num2)
            heapq.heappush(minheap,z)
            ans+=1
        
        return ans