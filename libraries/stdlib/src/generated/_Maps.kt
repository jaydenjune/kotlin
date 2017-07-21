@file:kotlin.jvm.JvmMultifileClass
@file:kotlin.jvm.JvmName("MapsKt")
@file:kotlin.jvm.JvmVersion

package kotlin.collections

//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

import kotlin.comparisons.*

/**
 * Returns a [List] containing all key-value pairs.
 */
public fun <K, V> Map<out K, V>.toList(): List<Pair<K, V>> {
    if (size == 0)
        return emptyList()
    val iterator = entries.iterator()
    if (!iterator.hasNext())
        return emptyList()
    val first = iterator.next()
    if (!iterator.hasNext())
        return listOf(first.toPair())
    val result = ArrayList<Pair<K, V>>(size)
    result.add(first.toPair())
    do {
        result.add(iterator.next().toPair())
    } while (iterator.hasNext())
    return result
}

/**
 * Returns a single list of all elements yielded from results of [transform] function being invoked on each entry of original map.
 */
public inline fun <K, V, R> Map<out K, V>.flatMap(transform: (Map.Entry<K, V>) -> Iterable<R>): List<R> {
    return flatMapTo(ArrayList<R>(), transform)
}

/**
 * Appends all elements yielded from results of [transform] function being invoked on each entry of original map, to the given [destination].
 */
public inline fun <K, V, R, C : MutableCollection<in R>> Map<out K, V>.flatMapTo(destination: C, transform: (Map.Entry<K, V>) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/**
 * Returns a list containing the results of applying the given [transform] function
 * to each entry in the original map.
 */
public inline fun <K, V, R> Map<out K, V>.map(transform: (Map.Entry<K, V>) -> R): List<R> {
    return mapTo(ArrayList<R>(size), transform)
}

/**
 * Returns a list containing only the non-null results of applying the given [transform] function
 * to each entry in the original map.
 */
public inline fun <K, V, R : Any> Map<out K, V>.mapNotNull(transform: (Map.Entry<K, V>) -> R?): List<R> {
    return mapNotNullTo(ArrayList<R>(), transform)
}

/**
 * Applies the given [transform] function to each entry in the original map
 * and appends only the non-null results to the given [destination].
 */
public inline fun <K, V, R : Any, C : MutableCollection<in R>> Map<out K, V>.mapNotNullTo(destination: C, transform: (Map.Entry<K, V>) -> R?): C {
    forEach { element -> transform(element)?.let { destination.add(it) } }
    return destination
}

/**
 * Applies the given [transform] function to each entry of the original map
 * and appends the results to the given [destination].
 */
public inline fun <K, V, R, C : MutableCollection<in R>> Map<out K, V>.mapTo(destination: C, transform: (Map.Entry<K, V>) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}

/**
 * Returns `true` if all entries match the given [predicate].
 */
public inline fun <K, V> Map<out K, V>.all(predicate: (Map.Entry<K, V>) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/**
 * Returns `true` if map has at least one entry.
 */
public fun <K, V> Map<out K, V>.any(): Boolean {
    return !isEmpty()
}

/**
 * Returns `true` if at least one entry matches the given [predicate].
 */
public inline fun <K, V> Map<out K, V>.any(predicate: (Map.Entry<K, V>) -> Boolean): Boolean {
    if (isEmpty()) return false
    for (element in this) if (predicate(element)) return true
    return false
}

/**
 * Returns the number of entries in this map.
 */
@kotlin.internal.InlineOnly
public inline fun <K, V> Map<out K, V>.count(): Int {
    return size
}

/**
 * Returns the number of entries matching the given [predicate].
 */
public inline fun <K, V> Map<out K, V>.count(predicate: (Map.Entry<K, V>) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/**
 * Performs the given [action] on each entry.
 */
@kotlin.internal.HidesMembers
public inline fun <K, V> Map<out K, V>.forEach(action: (Map.Entry<K, V>) -> Unit): Unit {
    for (element in this) action(element)
}

/**
 * Returns the first entry yielding the largest value of the given function or `null` if there are no entries.
 */
@kotlin.internal.InlineOnly
public inline fun <K, V, R : Comparable<R>> Map<out K, V>.maxBy(selector: (Map.Entry<K, V>) -> R): Map.Entry<K, V>? {
    return entries.maxBy(selector)
}

/**
 * Returns the first entry having the largest value according to the provided [comparator] or `null` if there are no entries.
 */
@kotlin.internal.InlineOnly
public inline fun <K, V> Map<out K, V>.maxWith(comparator: Comparator<in Map.Entry<K, V>>): Map.Entry<K, V>? {
    return entries.maxWith(comparator)
}

/**
 * Returns the first entry yielding the smallest value of the given function or `null` if there are no entries.
 */
public inline fun <K, V, R : Comparable<R>> Map<out K, V>.minBy(selector: (Map.Entry<K, V>) -> R): Map.Entry<K, V>? {
    return entries.minBy(selector)
}

/**
 * Returns the first entry having the smallest value according to the provided [comparator] or `null` if there are no entries.
 */
public fun <K, V> Map<out K, V>.minWith(comparator: Comparator<in Map.Entry<K, V>>): Map.Entry<K, V>? {
    return entries.minWith(comparator)
}

/**
 * Returns `true` if the map has no entries.
 */
public fun <K, V> Map<out K, V>.none(): Boolean {
    return isEmpty()
}

/**
 * Returns `true` if no entries match the given [predicate].
 */
public inline fun <K, V> Map<out K, V>.none(predicate: (Map.Entry<K, V>) -> Boolean): Boolean {
    if (isEmpty()) return true
    for (element in this) if (predicate(element)) return false
    return true
}

/**
 * Performs the given [action] on each entry and returns the map itself afterwards.
 */
@SinceKotlin("1.1")
public inline fun <K, V, M : Map<out K, V>> M.onEach(action: (Map.Entry<K, V>) -> Unit): M {
    return apply { for (element in this) action(element) }
}

/**
 * Creates an [Iterable] instance that wraps the original map returning its entries when being iterated.
 */
@kotlin.internal.InlineOnly
public inline fun <K, V> Map<out K, V>.asIterable(): Iterable<Map.Entry<K, V>> {
    return entries
}

/**
 * Creates a [Sequence] instance that wraps the original map returning its entries when being iterated.
 */
public fun <K, V> Map<out K, V>.asSequence(): Sequence<Map.Entry<K, V>> {
    return entries.asSequence()
}

