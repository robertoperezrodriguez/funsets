package funsets


/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = {
      def returnFunction(elem: Int)(input: Int): Boolean = {
        if (input == elem) true else false
      }
      return returnFunction(elem)
    }

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
    def union(s: Set, t: Set): Set = {
      def returnFunction(a: Set)(b: Set)(elem: Int): Boolean = {
        return a(elem) | b(elem)
      }
      return returnFunction(s)(t)
    }
  
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
    def intersect(s: Set, t: Set): Set = {
      def returnFunction(s: Set)(t: Set)(elem: Int): Boolean = {
        return s(elem) & t(elem)
      }
      return returnFunction(s)(t)
    }
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = {
      def returnFunction(elem: Int): Boolean = {
        return s(elem) & !t(elem)
      }
      return returnFunction
    }
  
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = {
      def returnFunction(elem: Int): Boolean = {
        return s(elem) & p(elem)
      }
      return returnFunction
    }
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
    def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (s(a) & !p(a)) return false
      else if (a == 1000) return true
      else iter(a + 1)
    }
    iter(-1000)
  }
  
  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
    def exists(s: Set, p: Int => Boolean): Boolean = {
      def iter(a: Int): Boolean = {
        if (s(a) & p(a)) return true
        else if (a == 1000) return false
        else iter(a + 1)
      }
      iter(-1000)
    }
  
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
    def map(s: Set, f: Int => Int): Set = ???

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
