import java.util.Arrays;

public class TestMyCircularlyDoublyLinkedList {
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		// Create a list for strings
		MyCircularlyDoublyLinkedList<String> list = new MyCircularlyDoublyLinkedList<>();

		// Add elements to the list
		list.add("America"); // Add America to the list
		System.out.println("(1) " + list);

		list.add(0, "Canada"); // Add Canada to the beginning of the list
		System.out.println("(2) " + list);

		list.add("Russia"); // Add Russia to the end of the list
		System.out.println("(3) " + list);

		list.addLast("France"); // Add France to the end of the list
		System.out.println("(4) " + list);

		list.add(2, "Germany"); // Add Germany to the list at index 2
		System.out.println("(5) " + list);



		list.add(5, "Norway"); // Add Norway to the list at index 5
		System.out.println("(6) " + list);

		list.add(0, "Poland"); // Same as list.addFirst("Poland")
		System.out.println("(7) " + list);

		list.addBefore("Australia", "Canada");
		System.out.println("(8) " + list);

		// Remove elements from the list
		list.remove(0); // Same as list.remove("Australia") in this case
		System.out.println("(9) " + list);

		list.remove(2); // Remove the element at index 2
		System.out.println("(10) " + list);

		list.remove(list.size() - 1); // Remove the last element
		System.out.print("(11) " + list + "\n(11) ");

		for (String s : list)
			System.out.print(s.toUpperCase() + " ");

		list.clear();
		System.out.println("\nAfter clearing the list, the list size is " + list.size());

		list.add("America");
		list.add("Canada");
		list.add("Russia");
        list.add("America");

		System.out.println("List contains \"America\": " + list.contains("America"));
		System.out.println("List contains \"France\": " + list.contains("France"));

		System.out.println("Element at index 1: " + list.get(1));
		System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Index of \"America\": " + list.indexOf("America"));
        System.out.println("Index of \"Russia\": " + list.indexOf("Russia"));

        System.out.println("Last index of \"America\": " + list.lastIndexOf("America"));
        System.out.println("Last index of \"Russia\": " + list.lastIndexOf("Russia"));

		System.out.println("Element at index 1: " + list.set(1, "France"));

		System.out.println("List after set: " + list);

		Object[] array = list.toArray();
		System.out.println("Array: " + Arrays.toString(array));

		String[] array2 = list.toArray(new String[10]);
		System.out.println("Array2: " + Arrays.toString(array2));


		System.out.println("Walk forward:");
		list.walkForward();
		System.out.println("");

		System.out.println("");
		System.out.println("Backward:");
		list.walkBackward();

		System.out.println("");
		System.out.println("Rotate:");
		list.rotate();
		list.walkForward();





	}


}