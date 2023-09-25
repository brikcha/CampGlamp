<?php

namespace App\Controller;
use App\Entity\Activite;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\ActiviteRepository;

class AdminController extends AbstractController
{
    /**
     * @Route("/back", name="app_admin")
     */
    public function index(): Response
    {
        return $this->render('back/Statistique.html.twig', [
            'controller_name' => 'AdminController',
        ]);
    }

   

}
