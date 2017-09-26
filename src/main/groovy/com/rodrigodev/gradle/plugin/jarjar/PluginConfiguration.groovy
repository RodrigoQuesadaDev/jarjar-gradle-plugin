package com.rodrigodev.gradle.plugin.jarjar

import com.rodrigodev.gradle.plugin.jarjar.PluginExtension
import com.rodrigodev.gradle.plugin.jarjar.tasks.repackage.RepackageConfiguration
import org.gradle.api.Project

class PluginConfiguration {

    private static final String EXTENSION_NAME = 'jarjar'

    private Project project
    final PluginExtension extension

    final RepackageConfiguration repackageConfiguration

    PluginConfiguration(Project project) {
        this.project = project;
        this.extension = project.extensions.create(EXTENSION_NAME, PluginExtension, project)
        this.repackageConfiguration = new RepackageConfiguration(this)
    }
}