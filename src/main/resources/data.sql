-- sample data for Waste Categories
INSERT INTO waste_categories (name, description) VALUES
    ('Plastic', 'All types of plastic materials and products.'),
    ('Organic Waste', 'Waste that can decompose, like food scraps or garden waste.'),
    ('Metal', 'All types of metal waste including cans and foil.');


-- sample data for Disposal Guidelines
INSERT INTO disposal_guidelines (title, instructions, waste_category_id, dos_list, donts_list) VALUES
    ('Plastic Recycling Guide', 'Proper disposal methods for plastic waste.', 1, 
    '["Rinse out containers before recycling.", "Remove plastic caps and lids.", "Keep plastics clean and dry."]', 
    '["Don''t include contaminated plastics.", "Don''t mix with other materials.", "Don''t recycle plastic bags in curbside bins."]'),

    ('Organic Waste Disposal Guide', 'Guide for composting and disposing of organic waste.', 2, 
    '["Add fruit and vegetable scraps to the compost.", "Include coffee grounds and eggshells.", "Shred leaves and branches for quicker decomposition."]', 
    '["Don''t include meat or dairy products.", "Don''t use plastic bags for organic waste.", "Don''t add diseased plants to compost."]'),

    ('Metal Recycling Guide', 'Proper methods for disposing of metal products.', 3, 
    '["Clean metal cans before recycling.", "Flatten cans to save space.", "Separate aluminum from steel."]', 
    '["Don''t include metal that is too large.", "Don''t mix with hazardous waste.", "Don''t recycle any metal that is not clean."]');


-- sample data for Recycling Tips
INSERT INTO recycling_tips (tip, waste_category_id) VALUES
    ('Always check the recycling symbols on plastics to ensure they are recyclable.', 1),
    ('Using a compost bin can significantly reduce the volume of waste sent to landfills.', 2),
    ('Batteries and certain metals require special disposal methods; check local guidelines.', 3);
