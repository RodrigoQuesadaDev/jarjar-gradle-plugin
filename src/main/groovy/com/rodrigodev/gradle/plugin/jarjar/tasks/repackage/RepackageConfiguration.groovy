package com.rodrigodev.gradle.plugin.jarjar.tasks.repackage

import com.rodrigodev.gradle.plugin.jarjar.PluginConfiguration
import com.rodrigodev.gradle.plugin.jarjar.PluginExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.file.FileCollection

class RepackageConfiguration {

    private static final String JARJAR = 'jarjar'
    private static final String REPACKAGE = 'repackage'

    PluginConfiguration pluginConfiguration
    Project project
    Configuration jarjarDependencies
    Configuration repackageDependencies
    @Delegate PluginExtension extension
    private FileCollection outputDependency

    RepackageConfiguration(PluginConfiguration pluginConfiguration) {
        this.pluginConfiguration = pluginConfiguration
        this.project = pluginConfiguration.project
        this.extension = pluginConfiguration.extension
        this.jarjarDependencies = project.configurations.create(JARJAR)
        this.repackageDependencies = project.configurations.create(REPACKAGE)
        this.outputDependency = project.files(extension.output)
    }
}