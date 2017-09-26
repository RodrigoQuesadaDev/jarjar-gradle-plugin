package com.rodrigodev.gradle.plugin.jarjar

import org.gradle.api.Project

class PluginExtension {

    private Project project;
    private Rules rules
    Set<String> excludes
    String output = 'libs/repackaged.jar'
    boolean verboseRepackaging

    PluginExtension(Project project) {
        this.project = project
        this.rules = new Rules(project)
    }

    Set getRules() {
        return rules.set
    }

    void rules(Closure closure) {
        project.configure(rules, closure)
    }

    class Rules {

        private Project project
        private Set<Map> set

        Rules(Project project) {
            this.project = project
            this.set = new HashSet()
        }

        void rule(Map map) {
            set.add(map)
        }

        void zap(String pattern) {
            addPatternElementMap(pattern)
        }

        void keep(String pattern) {
            addPatternElementMap(pattern)
        }

        private void addPatternElementMap(String pattern) {
            set.add(pattern: pattern)
        }
    }
}
