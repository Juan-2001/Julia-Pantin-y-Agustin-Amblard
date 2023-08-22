module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Point (Point, newP)
import City (City, newC)
import Quality (Quality, capacityQ, delayQ)
import Link (Link, linksL, delayL)
import Tunel (Tunel, connectsT, usesT, delayT)

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg [] [] []) = Reg [city] [] []
foundR (Reg cs ls ts) city = Reg (city:cs) ls ts

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cs ls ts) city1 city2 quality =
    let newLink = newL city1 city2 quality : ls
    in Reg cs newLink ts

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cs1 ls ts) cs2 = 


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ []) city1 city2 = False
connectedR (Reg cs ls (t:ts)) city1 city2 
    | connectsT city1 city2 t = True
    | otherwise = connectedR (Reg cs ls ts) city1 city2


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cs [] ts) city1 city2 = False
linkedR (Reg cs (l:ls) ts) city1 city2 
    | linksL city1 city2 l = True
    | otherwise = linkedR (Reg cs ls ts) city1 city2  

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg [] [] []) city1 city2 = 

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cs ls ts) city1 city2 = 