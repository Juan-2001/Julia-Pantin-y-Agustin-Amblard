module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point (Point, newP)
import City (City, newC, nameC)
import Quality (Quality, newQ, capacityQ, delayQ)
import Link (Link, newL, linksL, delayL)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun []) = False 
connectsT city1 city2 (Tun (link : linkS))
   | linksL city1 city2 link = True
   | otherwise = connectsT city1 city2 (Tun linkS)

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link1 (Tun []) = False
usesT link1 (Tun (link:linkS))
   | link1 == link = True
   | otherwise = usesT link1 (Tun linkS)

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0.0
delayT (Tun (link : linkS))
    = delayL link + delayT (Tun linkS)

