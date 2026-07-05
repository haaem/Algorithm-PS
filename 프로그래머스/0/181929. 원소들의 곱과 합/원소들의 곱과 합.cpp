#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int mult = 1;
    int sum = 0;
    for (int i = 0; i < num_list.size(); i++) {
        mult *= num_list[i];
        sum += num_list[i];
    }
    
    if (mult < sum * sum)
        return 1;
    return 0;
}