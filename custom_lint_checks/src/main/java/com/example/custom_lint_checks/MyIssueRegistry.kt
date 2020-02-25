package com.example.custom_lint_checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class MyIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(
            NoStyleSetDetector.ISSUE
        )

    override val api: Int
        get() = CURRENT_API
}