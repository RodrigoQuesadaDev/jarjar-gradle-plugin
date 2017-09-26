package com.rodrigodev.gradle.plugin.jarjar

import com.rodrigodev.gradle.plugin.jarjar.tasks.repackage.Repackage
import org.gradle.api.Plugin
import org.gradle.api.Project

class JarJarPlugin implements Plugin<Project> {

    private static final String JAVA_PLUGIN_ID = 'java'
    private static final String ANDROID_APPLICATION_PLUGIN_ID = 'com.android.application'
    private static final String ANDROID_LIBRARY_PLUGIN_ID = 'com.android.library'

    private Project project

    @Override
    void apply(Project project) {
        this.project = project

        PluginConfiguration pluginConfiguration = new PluginConfiguration(project);

        project.afterEvaluate {
            Repackage.setUp(project, pluginConfiguration.repackageConfiguration)
        }
    }

    private boolean isJavaProject() {
        project.plugins.findPlugin(JAVA_PLUGIN_ID)
    }

    private boolean isAndroidProject() {
        project.plugins.findPlugin(ANDROID_APPLICATION_PLUGIN_ID) || project.plugins.findPlugin(ANDROID_LIBRARY_PLUGIN_ID)
    }
}
