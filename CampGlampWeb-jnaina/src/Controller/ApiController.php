<?php

namespace App\Controller;
use DateTime;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

class ApiController extends AbstractController
{
    /**
     * @Route("/api", name="app_api")
     */
    public function index(): Response
    {
        return $this->render('api/index.html.twig', [
            'controller_name' => 'ApiController',
        ]);
    }

    /**
     * @Route("/api/{id}/edit", name="api_event_edit", methods={"PUT"})
     */
    public function majEvent(?Calendar $calender, Request $request)
    {
        // On récupère les données
        $donnees = json_decode($request->getContent());
        if(
            isset($donnees->title) && !empty($donnees->title) &&
            isset($donnees->start) && !empty($donnees->start) &&
            isset($donnees->description) && !empty($donnees->description) &&
            isset($donnees->backgroundColor) && !empty($donnees->backgroundColor) &&
            isset($donnees->borderColor) && !empty($donnees->borderColor) &&
            isset($donnees->textColor) && !empty($donnees->textColor)
        ){
            // Les données sont complètes
            // On initialise un code
            $code = 200;

            // On vérifie si l'id existe
            if(!$calender){
                // On instancie un rendez-vous
                $calender = new Calendar;

                // On change le code
                $code = 201;
            }

            // On hydrate l'objet avec les données
            $calender->setTitle($donnees->title);
            $calender->setDescription($donnees->description);
            $calender->setStart(new DateTime($donnees->start));
            if($donnees->allDay){
                $calender->setEnd(new DateTime($donnees->start));
            }else{
                $calender->setEnd(new DateTime($donnees->end));
            }
            $calender->setAllDay($donnees->allDay);
            $calender->setBackgroundColor($donnees->backgroundColor);
            $calender->setBorderColor($donnees->bordrColor);
            $calender->setTextColor($donnees->textColor);

            $em = $this->getDoctrine()->getManager();
            $em->persist($calender);
            $em->flush();

            // On retourne le code
            return new Response('Ok', $code);
        }else{
            // Les données sont incomplètes
            return new Response('Données incomplètes', 404);
        }


        return $this->render('api/index.html.twig', [
            'controller_name' => 'ApiController',
        ]);
    }
}
