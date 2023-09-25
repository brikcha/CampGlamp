<?php
// ...
class AppKernel extends Kernel
{
    public function registerBundles()
    {
        $bundles = [
            // ...
            new \MartinGeorgiev\SocialPostBundle\SocialPostBundle(),
        ];
        return $bundles;
    }
    // ...
}