<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Resevation
 *
 * @ORM\Table(name="resevation", indexes={@ORM\Index(name="idUser", columns={"idUser"}), @ORM\Index(name="fk3", columns={"id"})})
 * @ORM\Entity
 */
class Resevation
{
    /**
     * @var int
     *
     * @ORM\Column(name="idReservation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idreservation;

    /**
     * @var string
     *
     * @ORM\Column(name="Etat", type="string", length=50, nullable=false)
     */
    private $etat;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateReservation", type="date", nullable=false)
     */
    private $datereservation;

    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var \Event
     *
     * @ORM\ManyToOne(targetEntity="Event")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id", referencedColumnName="id")
     * })
     */
    private $id;


}
