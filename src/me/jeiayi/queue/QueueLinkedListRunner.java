package me.jeiayi.queue;

import java.util.LinkedList;

/*
 * 개와 고양이만 분양하는 분양소 분양 받는사람은 동물의 종류만 선택 가
 * 분양소에서 오래된순서대로 자동으로 부여됨
 * Linked List로  
 * */

enum AnimalType{
	DOG, CAT
}

abstract class Animal{
	AnimalType animalType;
	String name;
	int order;
	Animal(AnimalType type, String name){
		this.animalType = type;
		this.name =  name;
	}
	
	void setOrder(int i) {
		this.order = i;
	}
	
	int getOrder() {
		return this.order;
	}
	
	String info() {
		return animalType +"," + name +"," +order;
	}
}


class Dog extends Animal{
	Dog(String name){
		super(AnimalType.DOG, name);	
	} 
}

class Cat  extends Animal{
	Cat(String name){
		super(AnimalType.CAT, name);	
	} 
}


class AnimalShelter{
	LinkedList<Dog> dogsShelter = new LinkedList<Dog>();
	LinkedList<Cat> catsShelter = new LinkedList<Cat>();
	int order;
	
	AnimalShelter(){
		this.order=1;
	}
	
	void enqueue(Animal animal) {
		animal.setOrder(order++);
		
		
		if (animal.animalType== AnimalType.DOG) {
			dogsShelter.addLast((Dog)animal);
		}else if (animal.animalType==  AnimalType.CAT) {
			catsShelter.addLast((Cat)animal);
		} 
	}
	
	
	Animal dequeueDog() {
		return dogsShelter.poll();
	}
	
	Animal dequeueCat() {
		return catsShelter.poll();
	}
	
	Animal dequeue() {
		if(dogsShelter.size()==0 && catsShelter.size()==0 ) {
			return null;
		}else if(dogsShelter.size()==0) {
			return dequeueCat(); 
		}else if (catsShelter.size()==0) {
			return dequeueDog(); 
		}
		
		if (dogsShelter.peekFirst().getOrder() > catsShelter.peekFirst().getOrder()) {
			return dequeueCat(); 
		}else {
			return dequeueDog(); 
		}
	}
	
	
	
	
	
}

public class QueueLinkedListRunner {
	
	public static void main(String[] args) {
		
		Dog d1 = new Dog("D1");
		Dog d2 = new Dog("D2");
		Dog d3 = new Dog("D3");
		
		Cat c1 = new Cat("C1");
		Cat c2 = new Cat("C2");
		Cat c3 = new Cat("C3");
		
		AnimalShelter as  = new AnimalShelter();
		as.enqueue(d1);
		as.enqueue(c1);
		as.enqueue(d2);
		as.enqueue(c2);
		as.enqueue(c3);
		as.enqueue(d3);
		
		System.out.println(as.dequeueCat().info());
		System.out.println(as.dequeueCat().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeueDog().info());
		System.out.println(as.dequeueCat().info());
		
	}

}
