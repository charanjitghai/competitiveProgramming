#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
typedef long long ll;
class trainer{
public:
	int day, lectures, sadness;
	trainer(){

	}
	void set(int day, int lectures, int sadness){
		this->day = day;
		this->lectures = lectures;
		this->sadness = sadness;
	}
};

bool dayComp(trainer const &a, trainer const &b){
	return a.day < b.day;
}

bool sadnessComp(trainer const &a, trainer const &b){
	return a.sadness < b.sadness;
}

int main(){
	
	int t;
	cin >> t;
	trainer trainers[100000];
	while(t--){
		int n, d;
		cin >> n >> d;

		int day, lectures, sadness;
		ll totalSadness = 0;
		for(int i = 0; i<n; i++){
			cin >> day >> lectures >> sadness;
			trainers[i].set(day, lectures, sadness);
			totalSadness += lectures*sadness;
		}
		sort(trainers, trainers+n, dayComp);

		vector<trainer> vec;
		int last_trainer_idx = 0;
		bool added;
		for(int day = 1; day <= d; day++){
			added = false;
			while(last_trainer_idx < n && trainers[last_trainer_idx].day == day){
				vec.push_back(trainers[last_trainer_idx]);
				last_trainer_idx += 1;
				added = true;
			}

			if(added)
				sort(vec.begin(), vec.end(), sadnessComp);

			if(vec.size() > 0){
				trainer last = vec.back();
				totalSadness -= last.sadness;
				last.lectures -= 1;
				if(last.lectures == 0)
					vec.pop_back();
			}
		}

		cout << totalSadness << endl;

	}
}