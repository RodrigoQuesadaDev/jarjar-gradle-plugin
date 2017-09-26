package com.rodrigodev.gradle.plugin.jarjar.common

class VariantData {

    def variant

    String getSuffix() {
        return variant.name.capitalize() + variant.flavorName.capitalize()
    }
}