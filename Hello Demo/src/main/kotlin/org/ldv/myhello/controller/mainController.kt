package org.ldv.myhello.controller


import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.ui.set
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestParam

@Controller


class mainController {
    @GetMapping("/")
    fun index(model : Model) :String {
        model ["monTitre"]="Exemple d'une Vue"
        model ["monParagraphe"]="Ce paragraphe a été généré dynamiquement avec Thymleaf. "
        return "index"


    }
    @GetMapping("/hello")
    @ResponseBody
        fun querrySettings(@RequestParam querry : Map<String ,String>):String {
            val nom = querry["nom"] ?: ""
            val prenom = querry["prenom"] ?: ""
            return "<h2>Hello  ${nom} ${prenom} !!</h2> "
        }

    @GetMapping("/hello-{language}")
    @ResponseBody
        fun findlangage(@PathVariable("language") language :String,
                        request: HttpServletRequest) :String {
            return "vous Connaissez le language ${language} "
        }


}