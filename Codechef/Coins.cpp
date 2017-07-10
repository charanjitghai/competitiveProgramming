/*
** Problem: https://www.codechef.com/problems/FLIPCOIN
** Author: k1e13
*/
#include <iostream>
using namespace std;

class Node{
	int start;
	int end;
	int heads;
	int flips;
	int size;
	Node* left;
	Node* right;

public:
	Node(int start, int end){
		this->start = start;
		this->end = end;
		this->size = end - start + 1;
		this->heads = 0;
		this->flips = 0;
		this->left = NULL;
		this->right = NULL;
	}

	int getStart(){ return start; }
	int getEnd() { return end; }
	int getHeads() { return heads; }
	int getFlips() { return flips; }
	int getSize() { return size; }
	Node* getLeft() { return left;}
	Node* getRight() { return right;}


	void setHeads(int heads) { this->heads = heads;}
	void setFlips(int flips) { this->flips = flips;}
	void setLeft(Node* left) { this->left = left;}
	void setRight(Node* right) {this->right = right;}
	void toggle() {this->heads = this->size - this->heads;}

};


class Tree{
	Node* root;
	Node* initTree(int start, int end){
		
		if(start > end)
			return NULL;

		if(start == end){
			Node* node = new Node(start, end);
			return node;
		}

		int mid = (start + end)/2;
		Node* left = initTree(start, mid);
		Node* right = initTree(mid+1, end);
		
		Node* root = new Node(start, end);
		root->setLeft(left);
		root->setRight(right);
		return root;
	}
	void flip(Node* root, int qstart, int qend){

		if(root == NULL)
			return;

		if(root->getFlips() != 0){
			int flips = root->getFlips();
			if(flips%2 == 1)
				root->toggle();
			root->setFlips(0);


			Node* left = root->getLeft();
			if(left != NULL)
				left->setFlips(left->getFlips() + flips);

			Node* right = root->getRight();
			if(right != NULL)
				right->setFlips(right->getFlips() + flips);
		}

		if(root->getEnd() < qstart || root->getStart() > qend || qstart > qend)
			return;

		if(qstart <= root->getStart() && root->getEnd() <= qend){
			root->toggle();
			Node* left = root->getLeft();
			if(left != NULL)
				left->setFlips(left->getFlips() + 1);
			Node* right = root->getRight();
			if(right != NULL)
				right->setFlips(right->getFlips() + 1);
			return;
		}

		flip(root->getLeft(), qstart, qend);
		flip(root->getRight(), qstart, qend);
		
		int leftHeads = 0;
		if(root->getLeft() != NULL)
			leftHeads = root->getLeft()->getHeads();
		int rightHeads = 0;
		if(root->getRight() != NULL)
			rightHeads = root->getRight()->getHeads();

		root->setHeads(leftHeads + rightHeads);
	}

	int getHeads(Node* root, int qstart, int qend){
		if(root == NULL)
			return 0;

		if(root->getFlips() != 0){
			int flips = root->getFlips();
			if(flips%2 == 1)
				root->toggle();
			root->setFlips(0);


			Node* left = root->getLeft();
			if(left != NULL)
				left->setFlips(left->getFlips() + flips);

			Node* right = root->getRight();
			if(right != NULL)
				right->setFlips(right->getFlips() + flips);
		}

		if(root->getEnd() < qstart || root->getStart() > qend || qstart > qend)
			return 0;

		if(qstart <= root->getStart() && root->getEnd() <= qend)
			return root->getHeads();

		int leftHeads = getHeads(root->getLeft(), qstart, qend);
		int rightHeads = getHeads(root->getRight(), qstart, qend);

		return leftHeads + rightHeads;
	}

public:
	Tree(int start, int end){
		this->root = initTree(start, end);
	}
	void flip(int qstart, int qend){
		flip(this->root, qstart, qend);
	}
	int getHeads(int qstart, int qend){
		return getHeads(this->root, qstart, qend);
	}
};

int main(){
	int n, q;
	cin >> n >> q;

	Tree tree(0, n-1);

	int qt, qs, qe;
	while(q--){
		cin >> qt >> qs >> qe;

		if(qt == 0)
			tree.flip(qs, qe);
		else
			cout << tree.getHeads(qs, qe) << endl; 
	}

	return 0;
}







