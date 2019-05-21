package org.fansin.renamer

import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("No arguments")
            return
        }

        val directory = File(args[0])

        if (!directory.exists()) {
            println("That directory isn't exists")
        }

        if (!directory.isDirectory) {
            println("This isn't directory")
        }

        directory.walk().forEach {
            if (it.name.endsWith(".java") || it.name.endsWith(".kt")) {
                val newFile = File(it.path + ".2019")

                if (newFile.exists()) {
                    println("File " + it.path + " already exists")
                } else if (!it.renameTo(newFile)) {
                    println(it.path + " can't be renamed")
                } else {
                    println(it.path)
                }
            }
        }
    }

}