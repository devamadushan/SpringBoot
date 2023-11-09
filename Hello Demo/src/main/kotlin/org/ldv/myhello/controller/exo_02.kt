package org.ldv.myhello.controller


import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class exo_02 {
    @GetMapping("transmission-resultats")
        fun releverNotes(@RequestParam querry: Map<String,String>, model: Model):String{
            val dM = querry["Devoir_maison"] ?: ""
            val DM = dM.split("_")
            val qcm= querry["QCM"] ?: ""
            val QCM= qcm.split("_")
            val expose = querry["Expose"] ?: ""
            val Exposer = expose.split("_")
            val ds = querry["DS"] ?: ""
            val DS = ds.split("_")
            val mDM= DM[0].toDouble() * DM[1].toDouble()
            val mQCM= QCM[0].toDouble() * QCM[1].toDouble()
            val mExposer = Exposer[0].toDouble() * Exposer[1].toDouble()
            val mDS = DS[0].toDouble()*DS[1].toDouble()
            val coef = DM[0].toDouble()+QCM[0].toDouble()+Exposer[0].toDouble()+DS[0].toDouble()
        val moyenne = (mDM+mQCM+mExposer+mDS)/coef

            model["DMCO"]=DM[0]
            model["DMNO"]=DM[1]

            model["QCMCO"]=QCM[0]
            model["QCMNO"]=QCM[1]

            model["ExposeCO"]=Exposer[0]
            model["ExposeNO"]=Exposer[1]


            model["DSCO"]=DS[0]
            model["DSNO"]=DS[1]
            model["Moyenne"]=moyenne


            return "RelveDeNotes"
        }

}