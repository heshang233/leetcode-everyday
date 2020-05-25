package cn.leetcode.`146`

import java.util.HashMap

/**
 * @author huangsy
 * @date 2020/5/25 8:38
 */
class LRUCache {

    private val map = HashMap<Int, LinkNode?>()

    private var capacity = 0
    private var head: LinkNode? = null
    private var tail: LinkNode? = null

    inner class LinkNode {
        var key = 0
        var value = 0
        var preNode: LinkNode? = null
        var postNode: LinkNode? = null
    }

    fun LRUCache(capacity: Int) {
        this.capacity = capacity
        head = LinkNode()
        tail = LinkNode()
        head!!.postNode = tail
        tail!!.preNode = head
    }

    operator fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            val linkNode = map[key]
            linkNode!!.preNode!!.postNode = linkNode.postNode
            linkNode.postNode!!.preNode = linkNode.preNode
            linkNode.preNode = head
            linkNode.postNode = head!!.postNode
            linkNode.preNode!!.postNode = linkNode
            linkNode.postNode!!.preNode = linkNode
            head!!.postNode = linkNode
            linkNode.value
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        val linkNode: LinkNode?
        if (map.containsKey(key)) {
            linkNode = map[key]
            linkNode!!.value = value
            linkNode.preNode!!.postNode = linkNode.postNode
            linkNode.postNode!!.preNode = linkNode.preNode
            linkNode.preNode = head
            linkNode.postNode = head!!.postNode
            head!!.postNode = linkNode
        } else {
            linkNode = LinkNode()
            linkNode.key = key
            linkNode.value = value
            linkNode.preNode = head
            linkNode.postNode = head!!.postNode
            linkNode.preNode!!.postNode = linkNode
            linkNode.postNode!!.preNode = linkNode
            if (map.size >= capacity) {
                val preNode = tail!!.preNode
                tail!!.preNode = preNode!!.preNode
                preNode.preNode!!.postNode = tail
                preNode.preNode = null
                preNode.postNode = null
                map.remove(preNode.key)
            }
        }
        linkNode!!.preNode!!.postNode = linkNode
        linkNode.postNode!!.preNode = linkNode
        map[key] = linkNode
    }
}