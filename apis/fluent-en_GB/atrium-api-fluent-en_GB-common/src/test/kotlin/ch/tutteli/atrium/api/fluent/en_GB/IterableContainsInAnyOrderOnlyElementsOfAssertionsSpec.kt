package ch.tutteli.atrium.api.fluent.en_GB

import ch.tutteli.atrium.creating.Expect
import org.spekframework.spek2.Spek

class IterableContainsInAnyOrderOnlyElementsOfAssertionsSpec : Spek({
    include(BuilderSpec)
    include(BuilderIterableLikeToIterableSpec)
}) {
    object BuilderSpec : ch.tutteli.atrium.specs.integration.IterableContainsInAnyOrderOnlyValuesAssertionsSpec(
        getContainsPair(),
        getContainsNullablePair(),
        "◆ ", "✔ ", "✘ ", "❗❗ ", "⚬ ", "» "
    )

    object BuilderIterableLikeToIterableSpec : ch.tutteli.atrium.specs.integration.IterableLikeToIterableSpec<List<Int>>(
        "$contains.$inAnyOrder.$only.$inAnyOrderOnlyElementsOf",
        listOf(1, 2),
        { input -> contains.inAnyOrder.only.elementsOf(input) }
    )

    companion object : IterableContainsSpecBase() {
        fun getContainsPair() =
            "$contains.$inAnyOrder.$only.$inAnyOrderOnlyElementsOf" to Companion::getContainsValues

        private fun getContainsValues(
            expect: Expect<Iterable<Double>>,
            a: Double,
            aX: Array<out Double>
        ): Expect<Iterable<Double>> = expect.contains.inAnyOrder.only.elementsOf(listOf(a, *aX))

        fun getContainsNullablePair() =
            "$contains.$inAnyOrder.$only.$inAnyOrderOnlyElementsOf" to Companion::getContainsNullableValues

        private fun getContainsNullableValues(
            expect: Expect<Iterable<Double?>>,
            a: Double?,
            aX: Array<out Double?>
        ): Expect<Iterable<Double?>> = expect.contains.inAnyOrder.only.elementsOf(sequenceOf(a, *aX))
    }
}
