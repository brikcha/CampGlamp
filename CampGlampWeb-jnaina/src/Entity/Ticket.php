<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Ticket
 *
 * @ORM\Table(name="ticket", indexes={@ORM\Index(name="idReservation", columns={"idReservation"}), @ORM\Index(name="fk5", columns={"idOffre"})})
 * @ORM\Entity
 */
class Ticket
{
    /**
     * @var int
     *
     * @ORM\Column(name="idTicket", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idticket;

    /**
     * @var string|null
     *
     * @ORM\Column(name="reference", type="string", length=255, nullable=true)
     */
    private $reference;

    /**
     * @var float
     *
     * @ORM\Column(name="prixTicket", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixticket;

    /**
     * @var int
     *
     * @ORM\Column(name="idReservation", type="integer", nullable=false)
     */
    private $idreservation;

    /**
     * @var \Offre
     *
     * @ORM\ManyToOne(targetEntity="Offre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idOffre", referencedColumnName="idOffre")
     * })
     */
    private $idoffre;


}
