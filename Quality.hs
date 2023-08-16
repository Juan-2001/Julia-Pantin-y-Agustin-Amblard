module Quality ( Quality, newQ, capacityQ, delayQ )
   where
import Data.Text.Array (new)

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ = Qua


capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua canal capacity delay) = capacity


delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua canal capacity delay) = delay
