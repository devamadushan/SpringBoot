package org.ldv.myhello.modeles

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class monnayerController{
    @GetMapping("/monnayer")
    fun rendreMonnaie(
        @RequestParam ("rendre") somme : Double,
        model : Model
    ):String{
        val renduMonnaie = Monnayer.rendre(somme)
       //print(renduMonnaie.get(2.0))
        model.addAttribute("rendu",renduMonnaie)

//        model["deuxE"]=renduMonnaie.get(2.0)
//        model["1.0"]=renduMonnaie.get(1.0)
//        model["0.5"]=renduMonnaie.get(0.5)
//        model["0.2"]=renduMonnaie.get(0.2)
//        model["0.1"]=renduMonnaie.get(0.1)
//        model["0.05"]=renduMonnaie.get(0.05)
//        model["0.02"]=renduMonnaie.get(0.02)
//        model["0.01"]=renduMonnaie.get(0.01)
        model["maonnaie"]= somme
        return "monnayerResultat"
    }
}