package com.example.custom_lint_checks

import com.android.tools.lint.detector.api.*
import org.w3c.dom.Element

class NoStyleSetDetector : ResourceXmlDetector() {
    companion object {
        private val ID = "MissingStyle"
        private val DESC = "style missing on Button"
        private val EXPLANATION = "use a style please"
        private val VIEW = "Button"
        private val VIEW_2 = "com.google.android.material.button.MaterialButton"
        private val ATTR = "style"

        val ISSUE = Issue.Companion.create(
            ID,
            DESC,
            EXPLANATION,
            Category.CORRECTNESS,
            0,
            Severity.ERROR,
            Implementation(
                NoStyleSetDetector::class.java,
                Scope.RESOURCE_FILE_SCOPE
            )
        )
    }

    override fun getApplicableElements(): Collection<String>? {
        return listOf(VIEW, VIEW_2)
    }

    override fun visitElement(context: XmlContext, element: Element) {
        if (!element.hasAttribute(ATTR)) {
            context.report(
                ISSUE,
                context.getLocation(element),
                DESC
            )
        }
    }
}