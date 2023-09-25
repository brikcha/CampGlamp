<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Eventperso
 *
 * @ORM\Table(name="eventperso")
 * @ORM\Entity
 */
class Eventperso
{
    /**
     * @var int
     *
     * @ORM\Column(name="idep", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idep;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="location", type="string", length=255, nullable=false)
     */
    private $location;

    /**
     * @var int
     *
     * @ORM\Column(name="prix", type="integer", nullable=false)
     */
    private $prix;

    /**
     * @var string
     *
     * @ORM\Column(name="type", type="string", length=255, nullable=false)
     */
    private $type;

  //  /**
   //  * @var int
   //  *
   //  * @ORM\Column(name="iduser", type="integer", nullable=false)
  //   */
  //  private $iduser;


}
