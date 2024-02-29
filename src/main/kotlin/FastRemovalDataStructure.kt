class FastRemovalDataStructure<T> {
    private val map = HashMap<T, Node<T>>()
    private val head = Node<T>(null as T)
    private val tail = Node<T>(null as T)

    init {
        head.next = tail
        tail.prev = head
    }

    private class Node<T>(val value: T) {
        var prev: Node<T>? = null
        var next: Node<T>? = null
    }

    fun add(value: T) {
        if (map.containsKey(value)) return
        val newNode = Node(value)
        newNode.next = head.next
        newNode.prev = head
        head.next?.prev = newNode
        head.next = newNode
        map[value] = newNode
    }

    fun remove(value: T) {
        val nodeToRemove = map[value] ?: return
        nodeToRemove.prev?.next = nodeToRemove.next
        nodeToRemove.next?.prev = nodeToRemove.prev
        map.remove(value)
    }

    fun printList() {
        var current = head.next
        while (current != tail) {
            print("${current?.value} ")
            current = current?.next
        }
        println()
    }
}