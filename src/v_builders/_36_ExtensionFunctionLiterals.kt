package v_builders

import util.*

fun todoTask36() = TODO(
    """
        Task 36.
        Read about extension function literals.
        You can declare `isEven` and `isOdd` as values, that can be called as extension functions.
        Complete the declarations below.
    """,
    documentation = doc36()
)

fun task36(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0 }
    val isOdd: Int.() -> Boolean = { !isEven() }

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}



