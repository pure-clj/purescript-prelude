module Test.MyTest where

import Prelude

data May a = Jus a | Noth

instance mayFunctor :: Functor May where
  map f (Jus b) = Jus $ f b
  map _ _ = Noth

instance mayApply :: Apply May where
  apply (Jus f) (Jus b) = Jus $ f b
  apply _ _ = Noth

instance mayApplicative :: Applicative May where
  pure x = Jus x

instance mayBind :: Bind May where
  bind (Jus b) f = f b
  bind _ _ = Noth

instance mayMonad :: Monad May

theTest :: May Int
theTest = do
  pure 89