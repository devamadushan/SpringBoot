package org.ldv.myhello.modeles

object Monnayer {
    fun rendre(somme: Double):Map<Double , Int>{
        val pieces = listOf(2.0,1.0,0.5,0.2,0.1,0.05,0.02,0.01)
        val rendu = mutableMapOf<Double,Int>()
        var montantRestant = somme
        // verifier si dans rendu il y a deja une clé pieces[i]
        // si oui dans ce cas tu recup la valeur associé est tu incremente
        // Sinon tu set pieces[i] a 1
        //print(montantRestant)

        for (i in 0..pieces.size-1){
            //println(pieces[i])
            while(montantRestant>=pieces[i]){
                    //rendu.set(pieces[i],a)

                if(rendu.get(pieces[i])!=null){
                    val exA=rendu.get(pieces[i])
                    rendu.set(pieces[i],exA!!+1)
                    montantRestant-=pieces[i].toDouble()
                    }

                else{
                    rendu.set(pieces[i],1)
                    montantRestant-=pieces[i].toDouble()
                }
            }     }

            println(rendu)
        var test = 0
//        for (i in 0..rendu.size-1){
//            test =
//        }
        print(montantRestant)

        return rendu
    }
}