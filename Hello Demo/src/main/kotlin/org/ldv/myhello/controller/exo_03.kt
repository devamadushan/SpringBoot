package org.ldv.myhello.controller

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate
import org.springframework.ui.set
import org.springframework.ui.Model
import java.time.Year
import java.time.format.DateTimeFormatter
import java.util.Calendar

@Controller
class exo_03 {

    @GetMapping("/exo_3/formulaire")
        fun afficheFormulaire():String{
            return "formulaire"
        }
    @PostMapping("/templates/confirmationInscription")
        fun traitementFormulaire(
            model : Model,
            @RequestParam("titre") titre : String,
            @RequestParam("nom") nom : String,
            @RequestParam("prenom") prenom : String,
            @RequestParam("dateNaissance") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dateNaissance : LocalDate,)

        :String{
            val dataFormatee = dateNaissance.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            val age = dataFormatee.split('-')
            val calendar= Calendar.getInstance()
            val annee2=calendar.get(Calendar.YEAR)

            val ageCalcul = annee2-age[2].toInt()
            var statut = "mineur"
            if (ageCalcul>=18){
                statut = "majeur"
            }
        model["nom"]=nom
        model["prenom"]=prenom
        model["dateNaissance"]=dataFormatee
        model["age"]= ageCalcul
        model["statut"]=statut



        return "confirmationInscription"
        }

}