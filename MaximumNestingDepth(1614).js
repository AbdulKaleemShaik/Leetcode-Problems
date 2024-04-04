/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function (s) {
    let count = 0;
    let max = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            count++;
        }
        max = Math.max(count, max);
        if (s[i] === ')') {
            count--;
        }
    }
    return max;
};