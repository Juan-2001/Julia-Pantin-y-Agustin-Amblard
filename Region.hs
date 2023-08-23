module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR )
   where

import Point (Point, newP)
import City (City, newC, nameC)
import Quality (Quality, newQ, capacityQ, delayQ)
import Link (Link, linksL, delayL, newL)
import Tunel (Tunel, connectsT, usesT, delayT, newT)

data Region = Reg [City] [Link] [Tunel] deriving (Show)


newR :: Region
newR = Reg [][][]

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cs ls ts) city 
    | city `elem` cs = error "Esta ciudad ya forma parte de la region"
    | otherwise = Reg (city:cs) ls ts

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cs ls ts) city1 city2 quality =
    let newLink = newL city1 city2 quality : ls
    in Reg cs newLink ts
    
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cs1 ls ts) cs2 = -- HACER

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
delayR (Reg _ _ []) city1 city2 =  0.0
delayR (Reg cs ls (t:ts)) city1 city2
    | connectedR (Reg cs ls (t:ts)) city1 city2 = delayT t + delayR (Reg cs ls ts) city1 city2
    | otherwise = error "No estan conectadas"

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cs ls ts) city1 city2 = -- HACER