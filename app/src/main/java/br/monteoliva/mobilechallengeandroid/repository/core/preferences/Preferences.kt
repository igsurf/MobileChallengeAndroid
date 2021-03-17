package br.monteoliva.mobilechallengeandroid.repository.core.preferences

interface Preferences {
    fun getValue(key: String, defaultValue: String) : String
    fun getValue(key: String, defaultValue: Boolean) : Boolean
    fun getValue(key: String, defaultValue: Int) : Int

    fun setValue(key: String, value: String)
    fun setValue(key: String, value: Boolean)
    fun setValue(key: String, value: Int)
}