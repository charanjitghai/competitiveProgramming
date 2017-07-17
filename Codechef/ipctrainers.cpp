#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
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

bool sadnessCompf(trainer const &a, trainer const &b){
	return a.sadness < b.sadness;
}

class sadnessComp{
public:
	bool operator()(trainer a, trainer b){
		return a.sadness < b.sadness;
	}
};

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
			ll lect = (ll) lectures;
			totalSadness += lect*sadness;
		}
		sort(trainers, trainers+n, dayComp);

		priority_queue<trainer, vector<trainer>, sadnessComp> pq;
		int last_index = 0;

		for(int day=1; day <= d; day++){
			while(last_index < n && trainers[last_index].day == day){
				pq.push(trainers[last_index]);
				last_index++;
			}
			if(pq.size() > 0){
				trainer t = pq.top();
				pq.pop();
				totalSadness -= t.sadness;
				t.lectures -= 1;
				if(t.lectures != 0)
					pq.push(t);
			}
		}

		cout << totalSadness << endl;

	}
}