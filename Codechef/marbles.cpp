/*
** Problem: https://www.codechef.com/problems/MARBLEGF
** Author: k1e13
*/


#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
class Node{
	ll marbles;
	int start;
	int end;
	Node* left;
	Node* right;

public:
	Node(ll marbles, int start, int end){
		this->marbles = marbles;
		this->start = start;
		this->end = end;
		this->left = NULL;
		this->right = NULL;
	}
	void addMarbles(ll give){
		this->marbles = this->marbles + give;
	}
	void takeMarbles(ll take){
		this->marbles = this->marbles - take;
	}
	void setLeft(Node* left){
		this->left = left;
	}
	void setRight(Node* right){
		this->right = right;
	}
	Node* getLeft(){
		return this->left;
	}
	Node* getRight(){
		return this->right;
	}
	ll getMarbles(){
		return this->marbles;
	}
	int getStart(){
		return this->start;
	}
	int getEnd(){
		return this->end;
	}
};

class Tree{
	Node* root;
	Node* initTree(int start, int end, ll values[]){
		if(start > end)
			return NULL;
		if(start == end){
			return new Node(values[start], start, end);
		}
		
		int mid = (start + end)/2;
		Node* left = initTree(start, mid, values);
		Node* right = initTree(mid+1, end, values);
		
		Node* root = new Node(0, start, end);
		if(left != NULL)
			root->addMarbles(left->getMarbles());
		if(right != NULL)
			root->addMarbles(right->getMarbles());

		root->setLeft(left);
		root->setRight(right);
		
		return root;
	}

	Node* getResponsibleChild(Node* root, int idx){
		if(root == NULL)
			return NULL;
		Node* left = root->getLeft();
		if(left != NULL && left->getStart() <= idx && idx <= left->getEnd())
			return left;

		Node* right = root->getRight();
		if(right != NULL && right->getStart() <= idx && idx <= right->getEnd())
			return right;

		return NULL;
	}

	void giveMarbles(Node* root, int idx, ll give){
		if(root == NULL)
			return;
		root->addMarbles(give);

		Node* responsibleChild = getResponsibleChild(root, idx);
		giveMarbles(responsibleChild, idx, give);
	}

	void takeMarbles(Node* root, int idx, int take){
		giveMarbles(root, idx, -take);
	}

	ll getSum(Node* root, int qstart, int qend){
		if(root == NULL)
			return 0;
		if(qstart > qend || qend < root->getStart() || root->getEnd() < qstart)
			return 0;

		if(qstart <= root->getStart() && root->getEnd() <= qend)
			return root->getMarbles();

		return getSum(root->getLeft(), qstart, qend) + getSum(root->getRight(), qstart, qend);

	}

	void printTree(Node* root){
		if(root == NULL)
			return;
		cout << root->getMarbles() << endl;
		printTree(root->getLeft());
		printTree(root->getRight());
	}

public:
	void giveMarbles(int idx, int give){
		giveMarbles(this->root, idx, give);
	}
	void takeMarbles(int idx, int take){
		takeMarbles(this->root, idx, take);
	}
	ll getSum(int qstart, int qend){
		return getSum(this->root, qstart, qend);
	}
	Tree(int start, int end, ll values[]){
		this->root = initTree(start, end, values);
	}
	void printTree(){
		printTree(root);
	}
};




int main(){
	int n, q;
	ll v[1000000];

	cin >> n >> q;
	for(int i =0; i<n; i++)
		cin >> v[i];

	Tree tree(0, n-1, v);
	//tree.printTree();

	string qt;
	while(q--){

		cin >> qt;
		if(qt == "S"){
			int qs, qe;
			cin >> qs >> qe;
			cout << tree.getSum(qs, qe) << endl;
		}
		else if(qt == "G"){
			int idx, give;
			cin >> idx >> give;
			tree.giveMarbles(idx, give);
		}
		else{
			int idx, take;
			cin >> idx >> take;
			tree.takeMarbles(idx, take);
		}

	}
}











