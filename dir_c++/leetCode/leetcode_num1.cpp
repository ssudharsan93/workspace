#include <map>
#include <vector>
#include <iostream>

using namespace std;

//Two Sum Solution
// Return both indices of the elements that add up to target.
vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> mymap;

        for ( int i = 0; i < nums.size(); i++ ) {
            if ( mymap.count(target - nums[i]) ) {
                return (vector<int>) { mymap[target - nums[i]], i };
            }

            mymap[nums[i]] = i;
        }

        return (vector<int>) {-1, -1};
}

int main() {
    vector<int> input = {-5, 6, 7, 8, -11, 2};
    int target = 9;

    vector<int> res = twoSum(input, target);

    cout << res[0] << endl;
    cout << res[1] << endl;

    return 0;
}
