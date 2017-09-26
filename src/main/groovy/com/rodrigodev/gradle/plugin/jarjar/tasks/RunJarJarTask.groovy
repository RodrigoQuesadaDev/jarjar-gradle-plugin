package com.rodrigodev.gradle.plugin.jarjar.tasks

import org.gradle.api.DefaultTask

abstract class RunJarJarTask extends DefaultTask {

    static final String TASK_NAMESPACE = 'runJarJar'

    static String namespace(String name, String suffix = null) {
        return "${TASK_NAMESPACE}_${name}" + (suffix ? suffix.capitalize() : '')
    }
}