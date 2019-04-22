package edu.miracostacollege.cs134.petprotector.model;

/** Model class representing a Pet in this PetProtector project **/
public class Pet {

    /** Private members **/
    private String mDetails;
    private int mId;
    private String mImageUri;
    private String mName;
    private String mPhone;

    /**
     * Default constructor for a default pet object.
     */
    public Pet() {
        mDetails = "Basic details!";
        mId = -1;
        mImageUri = "";
        mName = "John Doe";
        mPhone = "123-1234";
    }

    /**
     * Overloaded constructor for a new custom pet object.
     * @param name The desired name for this pet.
     * @param phone The desired phone number to be attached to this pet.
     * @param imageUri The desired imageUri to be attached to this pet.
     * @param id The desired ID for this pet.
     * @param details The desired details blurb for this pet.
     */
    public Pet(String name, String phone, String imageUri, int id, String details) {
        mName = name;
        mPhone = phone;
        mImageUri = imageUri;
        mId = id;
        mDetails = details;
    }


    /**
     * Accessor method for the details of this pet.
     * @return This pet's details as a string.
     */
    public String getDetails() {
        return mDetails;
    }

    /**
     * Accessor method for the id of this pet.
     * @return This pets id as an integer.
     */
    public int getId() {
        return mId;
    }

    /**
     * Accessor method for the imageUri of this pet.
     * @return This pet object's imageUri as a String.
     */
    public String getImageUri() {
        return mImageUri;
    }

    /**
     * Accesor method for the name of this pet.
     * @return The name of this pet as a String.
     */
    public String getName() {
        return mName;
    }

    /**
     * Accessor method for the phone number.
     * @return The phone number as a string.
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * Mutator method for the details of this Pet.
     * @param details The desired details of this pet as a String.
     */
    public void setDetails(String details) {
        mDetails = details;
    }

    /**
     * Mutator method for the imageUri for this Pet.
     * @param imageUri The desired imageUri of this pet as a String.
     */
    public void setImageUri(String imageUri) {
        mImageUri = imageUri;
    }

    /**
     * Mutator method for the name of this pet.
     * @param name The desired name of this pet.
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Mutator method for the contact phone number of this pet.
     * @param phone The desired phone number.
     */
    public void setPhone(String phone) {
        mPhone = phone;
    }

    /**
     * Simple toString method for this Pet.
     * @return A meaningful representation of this object's data as a string.
     */
    @Override
    public String toString() {
        return "Pet{" +
                "mDetails='" + mDetails + '\'' +
                ", mId=" + mId +
                ", mImageUri='" + mImageUri + '\'' +
                ", mName='" + mName + '\'' +
                ", mPhone='" + mPhone + '\'' +
                '}';
    }
}
