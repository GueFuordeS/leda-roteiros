package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class StudentAVLTest2 {
	private AVLTree<Integer> avl;

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}
	
	@Test
	public void testRemove1() {
		
		avl.insert(55);
		avl.insert(9);
		avl.insert(60);
		avl.insert(56);
		
		assertEquals(new Integer(55), avl.getRoot().getData());
		assertArrayEquals(new Integer[] {55, 9, 60, 56} , avl.preOrder());
		
		avl.remove(9);
		
		assertArrayEquals(new Integer[] {56, 55, 60} , avl.preOrder());
		
		avl.insert(54);
		avl.insert(53);
		
		assertArrayEquals(new Integer[] {56, 54, 53, 55, 60} , avl.preOrder());
		
		
		
	}
	
	@Test
	public void testRemove2() {
		
		avl.insert(16);
		avl.insert(7);
		avl.insert(89);
		avl.insert(4);
		avl.insert(11);
		avl.insert(32);
		avl.insert(94);
		avl.insert(9);
		avl.insert(17);
		avl.insert(69);
		avl.insert(95);
		avl.insert(33);
		avl.insert(73);
		
		
		assertArrayEquals(new Integer[] {16, 7, 4, 11, 9, 89, 32, 17, 69, 33, 73, 94, 95}, avl.preOrder());
		
		avl.remove(9);
		
		assertArrayEquals(new Integer[] {32, 16, 7, 4, 11, 17, 89, 69, 33, 73, 94, 95}, avl.preOrder());
		
		
	}
	
	@Test
	public void testRemove3() {
		
		avl.insert(99);
		avl.insert(36);
		avl.insert(12);
		avl.insert(76);
		avl.insert(15);
		avl.insert(49);
		avl.insert(19);
		avl.insert(84);
		avl.insert(22);
		avl.insert(92);
		
		//System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] {36, 15, 12, 19, 22, 76, 49, 92, 84, 99}, avl.preOrder());
		
		avl.remove(49);
		
		assertArrayEquals(new Integer[] {36, 15, 12, 19, 22, 92, 76, 84, 99}, avl.preOrder());
		
		avl.remove(12);
		
		assertArrayEquals(new Integer[] {36, 19, 15, 22, 92, 76, 84, 99}, avl.preOrder());
		
		avl.remove(22);
		
		assertArrayEquals(new Integer[] {36, 19, 15, 92, 76, 84, 99}, avl.preOrder());
		
		avl.remove(15);
		
		assertArrayEquals(new Integer[] {76, 36, 19, 92, 84, 99}, avl.preOrder());
		
		avl.remove(19);
		
		assertArrayEquals(new Integer[] {76, 36, 92, 84, 99}, avl.preOrder());
		
		avl.remove(36);
		
		assertArrayEquals(new Integer[] {92, 76, 84 , 99} , avl.preOrder());
		
		avl.remove(99);
		
		assertArrayEquals(new Integer[] {84, 76, 92}, avl.preOrder());
	}
}