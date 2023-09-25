<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;//controle de saisie

/**
 * Event
 *
 * @ORM\Table(name="event", indexes={@ORM\Index(name="IDX_3BAE0AA7A5B142EF", columns={"idCentre"})})
 * @ORM\Entity
 */
class Event
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
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     * * @Assert\NotBlank( message="le nom  doit  ètre  non vide")
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     * * @Assert\NotBlank(message="description  doit etre non vide")
     * @Assert\Length(
     *      min = 7,
     *      max = 100,
     *      minMessage = "doit etre >=7 ",
     *      maxMessage = "doit etre <=100" )
     */
    private $description;

    /**
  * @var enum
  *
  *@ORM\Column(name="type", type="string", columnDefinition="enum(' RANDONNEE', 'CAMPING','GLAMPING')")
  ** @Assert\NotBlank(message=" type doit etre non vide")
     * @Assert\Length(
     *      min = 5,
     *      minMessage=" Entrer un type au mini de 5 caractères"
     *
     *     )
     */
  private $type;
     

    /**
     * @var string
     *
     * @ORM\Column(name="lieu", type="string", length=255, nullable=false)
     * * @Assert\NotBlank( message="le lieu doit ètre non vide")
     */
    private $lieu;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     * * @Assert\NotBlank( message="la date  doit ètre non vide")
     */
    private $date;

    /**
     * @var float
     *
     * @ORM\Column(name="prix", type="float", precision=10, scale=0, nullable=false)
     * * @Assert\NotBlank( message="le prix doit  ètre non vide")
     */
    private $prix;

     /**
     * @var string
     * @ORM\Column(type="string", length=255)
     * * @Assert\NotBlank( message="l'image doit ètre non vide")
     */
    private $image;
     
  /**
  * @var enum
  *
  *@ORM\Column(name="status", type="string", columnDefinition="enum(' FINI', 'PROGRAMMEE')")
  ** @Assert\NotBlank(message=" status doit ètre non vide")
     * @Assert\Length(
     *      min = 3,
     *      minMessage=" Entrer une status au mini de 3 caractères"
     *
     *     )
  */
  private $status;

//  /**
 //  * @ORM\OneToMany(targetEntity=Activite::class, mappedBy="relation")
 //  */
 // private $relation;



  

 
    

   

  /**
    * @var \CentreDeCamping
    *
    * @ORM\ManyToOne(targetEntity="CentreDeCamping")
   * @ORM\JoinColumns({
    *   @ORM\JoinColumn(name="idCentre", referencedColumnName="idCentre")
    * })
   */
   private $idcentre;

  // /**
  //  * @var \Doctrine\Common\Collections\Collection
  //  *
  //  * @ORM\ManyToMany(targetEntity="Utilisateurs", inversedBy="eventid")
   // * @ORM\JoinTable(name="event_user",
   // *   joinColumns={
   // *     @ORM\JoinColumn(name="eventid", referencedColumnName="id")
   // *   },
  //  *   inverseJoinColumns={
   // *     @ORM\JoinColumn(name="idUser", referencedColumnName="idUser")
   // *   }
  //  * )
  //  */
  // private $iduser;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->iduser = new \Doctrine\Common\Collections\ArrayCollection();
        $this->Relation = new ArrayCollection();
        $this->relation = new ArrayCollection();
    }

     public function getId(): ?int
    {
        return $this->id;
    }

    public function getIdCentre(): ?int
    {
        return $this->id;
   }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getType()
    {
        return $this->type;
    }

    public function setType( $type)
    {
        $this->type = $type;

        return $this;
    }



    public function getLieu(): ?string
    {
        return $this->lieu;
    }

    public function setLieu(string $lieu): self
    {
        $this->lieu= $lieu;

        return $this;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getPrix(): ?float
    {
        return $this->prix;
    }

    public function setPrix(float $prix): self
    {
        $this->prix= $prix;

        return $this;
    }

    
    public function getImage()
    {
        return $this->image;
    }

    public function setImage($image)
    {
        $this->image = $image;

        return $this;
    }

 
  public function setStatus( $status)
{
    $this->status= $status;

    return $this;
}

public function getStatus()
{
    return $this->status;
}

///**
// * @return Collection<int, Activite>
// */
//public function getRelation(): Collection
//{
   // return $this->relation;
//}

//public function addRelation(Activite $relation): self
//{
   // if (!$this->relation->contains($relation)) {
      //  $this->relation[] = $relation;
        //$relation->setRelation($this);
   // }

   // return $this;
//}

//public function removeRelation(Activite $relation): self
//{
  //  if ($this->relation->removeElement($relation)) {
        // set the owning side to null (unless already changed)
    //    if ($relation->getRelation() === $this) {
      //      $relation->setRelation(null);
        //}
    //}

    //return $this;
//}







   
     

   


}
