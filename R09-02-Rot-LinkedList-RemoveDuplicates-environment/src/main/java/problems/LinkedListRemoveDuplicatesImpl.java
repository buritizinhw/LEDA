package problems;

import java.util.HashSet;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node) {
        if (node == null || node.getNext() == null) {
            return;
        }
        HashSet<T> uniqueElements = new HashSet<>();
        uniqueElements.add(node.getData());

        SingleLinkedListNode<T> current = node;

        while (current.getNext() != null) {
            T data = current.getNext().getData();

            if (uniqueElements.contains(data)) {
                current.setNext(current.getNext().getNext());
            } else {
                uniqueElements.add(data);
                current = current.getNext();
            }
        }
    }
}

