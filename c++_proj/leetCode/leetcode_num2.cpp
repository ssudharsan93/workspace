#include <map>
#include <vector>
#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}

    ListNode* turnListIntoLinkedList(ListNode *listToBeConverted){

    }

    void printListNodes(ListNode *linkedListToPrint){
        bool another_node_poss = true;
        ListNode *current_node_pos = *linkedListToPrint;
        while (another_node_poss) {
            cout << (*current_node_pos).val << " -> ";
            if ((*current_node_pos).next = NULL) {
                cout << "NONE" << endl;
                another_node_poss = false;
            }
        }
     }
};

//Adding Two Numbers Solution
// Return a ListNode pointer with a reference to the sum populated in reverse order.
ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {

}

int main() {
    int l1[] = {2, 4, 3};
    int l2[] = {5, 6, 4};
    int l3[] = {9, 9, 9};
    int l4[] = {9, 9, 9, 9, 9};

    return 0;
}
