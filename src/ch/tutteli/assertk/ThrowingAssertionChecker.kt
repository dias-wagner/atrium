package ch.tutteli.assertk

class ThrowingAssertionChecker(private val reporter: IReporter) : IAssertionCheckerDelegateFail, IAssertionChecker {

    override fun check(assertionVerb: String, subject: Any, assertions: List<IAssertion>) {
        val sb = StringBuilder()
        val assertionGroup = AssertionGroup(assertionVerb, subject, assertions)
        reporter.format(sb, assertionGroup)
        if (!assertionGroup.holds()) {
            throw AssertionError(sb.toString())
        }
    }

}