<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Offre
 *
 * @ORM\Table(name="offre")
 * @ORM\Entity
 */
class Offre
{
    /**
     * @var int
     *
     * @ORM\Column(name="idOffre", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idoffre;

    /**
     * @var float
     *
     * @ORM\Column(name="remise", type="float", precision=10, scale=0, nullable=false)
     */
    private $remise;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateDebut", type="date", nullable=false)
     */
    private $datedebut;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateFin", type="date", nullable=false)
     */
    private $datefin;

    /**
     * @var int
     *
     * @ORM\Column(name="nbrTicket", type="integer", nullable=false)
     */
    private $nbrticket;


}
