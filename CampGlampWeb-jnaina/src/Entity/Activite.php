<?php

namespace App\Entity;


use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;//controle de saisie

/**
 * Activite
 *
 * @ORM\Table(name="activite")
 * @ORM\Entity
 */
class Activite
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nomActivite", type="string", length=255, nullable=false)
     * * @Assert\NotBlank( message="le nom  doit ètre  non vide")
     */
    private $nomActivite;

    /**
     * @var enum
     *
     * @ORM\Column(name="typeActivite", type="string",columnDefinition="enum(' LOISIR', 'SPORTIF','NAUTIQUE')")
     * * @Assert\NotBlank(message=" type doit ètre non vide")
     * @Assert\Length(
     *      min = 3,
     *      minMessage=" Entrer un type au mini de 3 caractères"
     *
     *     )
     */
    private $typeActivite;

    /**
     * @var int
     *
     * @ORM\Column(name="prixActivite", type="integer", nullable=false)
     *  @Assert\NotBlank( message="le prix doit ètre non  vide")
     */
    private $prixActivite;

    /**
     * @var string
     *
     * @ORM\Column(name="video", type="string", length=255, nullable=false)
     *  @Assert\NotBlank( message="la vidéo doit ètre  non vide")
     */
    private $video;

   // /**
    // * @ORM\ManyToOne(targetEntity=Event::class, inversedBy="relation")
    // */
    //private $relation;

    /**
     * @ORM\Column(name="nomparticipant",type="string", length=255)
     */
    private $nomparticipant;


    /**
     * @ORM\Column(name="numeroparticipant",type="string", length=255)
     */
    private $numeroparticipant;

    




   

   // /**
    // * @var int|null
    // *
    // * @ORM\Column(name="nombre de participants", type="integer", nullable=true)
    // */
   // private $nombreDeParticipants;

    public function __construct()
    {
        $this->iduser = new \Doctrine\Common\Collections\ArrayCollection();
        $this->Relation = new ArrayCollection();
        $this->events = new ArrayCollection();
        $this->relation = new ArrayCollection();
    }

     public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomActivite(): ?string
    {
        return $this->nomActivite;
    }

    public function setNomActivite(string $nomActivite): self
    {
        $this->nom = $nomActivite;

        return $this;
    }


    public function getTypeActivite()
    {
        return $this->typeActivite;
    }

    public function setTypeActivite( $typeActivite)
    {
        $this->typeActivite= $typeActivite;

        return $this;
    }

    public function getPrixActivite(): ?int
    {
        return $this->prixActivite;
    }

    public function setPrixActivite(int $prixActivite): self
    {
        $this->prixActivite= $prixActivite;

        return $this;
    }

    
    public function getVideo()
    {
        return $this->video;
    }

    public function setVideo($video)
    {
        $this->video = $video;

        return $this;
    }


    public function getNomparticipant(): ?string
    {
        return $this->nomparticipant;
    }

    public function setNomparticipant(string $nomparticipant): self
    {
        $this->nomparticipant = $nomparticipant;

        return $this;
    }

    public function getNumeroparticipant(): ?string
    {
        return $this->numeroparticipant;
    }

    public function setNumeroparticipant(string $numeroparticipant): self
    {
        $this->numeroparticipant = $numeroparticipant;

        return $this;
    }

 
 // public function setNombredeparticipants( int $nombreDeParticipants)
//{
   // $this->nombreDeParticipants= $nombreDeParticipants;

  //  return $this;
//}

//public function getNombredeparticipants()
//{
  //  return $this->nombreDeParticipants;
//}

# jointure :
//public function getRelation(): ?Event
//{
   // return $this->relation;
//}

//public function setRelation(?Event $relation): self
//{
   // $this->relation = $relation;

   // return $this;
//}





}



 

   
     
