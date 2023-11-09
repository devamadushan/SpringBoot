package org.ldv.myhello.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class exo_01 {
//    @GetMapping("/wonderfast/mycommand")
//    @ResponseBody
//        fun client(@RequestParam querry: Map<String,String>) :String {
//            val name = querry["name"] ?: ""
//            val surName = querry["surname"] ?: ""
//            val starter = querry["starter"] ?: ""
//            val maincourse = querry["maincourse"] ?: ""
//            val desert = querry["desert"] ?: ""
//            val drink = querry["drink"] ?: ""
//
//            return "<h1> Commande de ${name} ${surName} :</h1> <ul> <li>${starter.replace('_' , ' ')}</li> <li> ${maincourse.replace('_' , ' ')}</li> <li>${desert.replace('_' , ' ')}</li> <li> ${drink.replace('_' , ' ')} </li><ul> "
//        }
//

    @GetMapping("/wonderfast/mycommand")
    fun client(@RequestParam querry: Map<String,String>,model:Model) :String {
        val name = querry["name"] ?: ""
        val surName = querry["surname"] ?: ""
        val starter = querry["starter"] ?: ""
        val maincourse = querry["maincourse"] ?: " "
        val desert = querry["desert"] ?: " "
        val drink = querry["drink"] ?: " "
        model["name"]=name
        model.addAttribute("surname",surName)
        model["starter"]=starter
        model["mainCourse"]=maincourse.replace('_',' ')
        model["desert"]=desert.replace('_',' ')
        model["drink"]=drink.replace('_',' ')
        return "client"
    }
}