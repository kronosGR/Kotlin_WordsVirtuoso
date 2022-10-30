fun compose(g: (Int) -> Int, h: (Int) -> Int): (Int) -> Int = {
   x -> g(h(x))
}